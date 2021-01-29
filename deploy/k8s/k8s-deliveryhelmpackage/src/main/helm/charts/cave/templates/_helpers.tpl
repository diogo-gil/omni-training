{{/* vim: set filetype=mustache: */}}
{{/*
Expand the name of the chart.
*/}}
{{- define "cave.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
*/}}
{{- define "cave.fullname" -}}
{{- $name := default .Chart.Name .Values.nameOverride -}}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a chart name
*/}}
{{- define "cave.chartname" -}}
{{- $chartVersion := .Chart.Version | replace "+" "_" -}}
{{- printf "%s-%s" .Chart.Name $chartVersion | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Defines the credential secret
*/}}
{{- define "cave.credentialsecret" -}}
credential-{{ template "cave.fullname" . }}
{{- end -}}

{{/*
Defines the registry secret
*/}}
{{- define "cave.containersecret" -}}
registry-{{ template "cave.fullname" . }}
{{- end -}}

{{/*
Defines the client service
*/}}
{{- define "cave.clientservice" -}}
client-delivery-cave
{{- end -}}

{{/*
Defines the headless service
*/}}
{{- define "cave.headlessservice" -}}
headless-delivery-cave
{{- end -}}

{{/*
Defines the image pull secret data
*/}}
{{- define "cave.imagePullSecret" }}
{{- printf "{\"%s\":{\"username\":\"%s\",\"password\":\"%s\",\"email\":\"%s\"}, \"%s\":{\"username\":\"%s\",\"password\":\"%s\",\"email\":\"%s\"}}" .Values.secret.container.name .Values.secret.container.user .Values.secret.container.password .Values.secret.container.email .Values.secret.initcontainer.name .Values.secret.initcontainer.user .Values.secret.initcontainer.password .Values.secret.initcontainer.email | b64enc }}
{{- end -}}