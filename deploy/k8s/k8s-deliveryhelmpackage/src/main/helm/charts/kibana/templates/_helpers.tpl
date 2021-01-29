{{/* vim: set filetype=mustache: */}}
{{/*
Expand the name of the chart.
*/}}
{{- define "kibana.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
*/}}
{{- define "kibana.fullname" -}}
{{- $name := default .Chart.Name .Values.nameOverride -}}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a chart name
*/}}
{{- define "kibana.chartname" -}}
{{- $chartVersion := .Chart.Version | replace "+" "_" -}}
{{- printf "%s-%s" .Chart.Name $chartVersion | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Defines the credential secret
*/}}
{{- define "kibana.credentialsecret" -}}
credential-{{ template "kibana.fullname" . }}
{{- end -}}

{{/*
Defines the registry secret
*/}}
{{- define "kibana.containersecret" -}}
registry-{{ template "kibana.fullname" . }}
{{- end -}}

{{/*
Defines the client service
*/}}
{{- define "kibana.clientservice" -}}
client-delivery-kibana
{{- end -}}

{{/*
Defines the headless service
*/}}
{{- define "kibana.headlessservice" -}}
headless-delivery-kibana
{{- end -}}

{{/*
Defines the image pull secret data
*/}}
{{- define "kibana.imagePullSecret" }}
{{- printf "{\"%s\":{\"username\":\"%s\",\"password\":\"%s\",\"email\":\"%s\"}}" .Values.secret.container.name .Values.secret.container.user .Values.secret.container.password .Values.secret.container.email | b64enc }}
{{- end -}}