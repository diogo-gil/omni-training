{{/* vim: set filetype=mustache: */}}
{{/*
Expand the name of the chart.
*/}}
{{- define "orientdb.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
*/}}
{{- define "orientdb.fullname" -}}
{{- $name := default .Chart.Name .Values.nameOverride -}}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a chart name
*/}}
{{- define "orientdb.chartname" -}}
{{- $chartVersion := .Chart.Version | replace "+" "_" -}}
{{- printf "%s-%s" .Chart.Name $chartVersion | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Defines the credential secret
*/}}
{{- define "orientdb.credentialsecret" -}}
credential-{{ template "orientdb.fullname" . }}
{{- end -}}

{{/*
Defines the registry secret
*/}}
{{- define "orientdb.containersecret" -}}
registry-{{ template "orientdb.fullname" . }}
{{- end -}}

{{/*
Defines the client service
*/}}
{{- define "orientdb.clientservice" -}}
client-delivery-orientdb
{{- end -}}

{{/*
Defines the headless service
*/}}
{{- define "orientdb.headlessservice" -}}
headless-delivery-orientdb
{{- end -}}

{{/*
Defines the image pull secret data
*/}}
{{- define "orientdb.imagePullSecret" }}
{{- printf "{\"%s\":{\"username\":\"%s\",\"password\":\"%s\",\"email\":\"%s\"}}" .Values.secret.container.name .Values.secret.container.user .Values.secret.container.password .Values.secret.container.email | b64enc }}
{{- end -}}
