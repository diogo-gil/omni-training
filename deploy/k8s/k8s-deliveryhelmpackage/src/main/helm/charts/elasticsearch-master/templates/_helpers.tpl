{{/* vim: set filetype=mustache: */}}
{{/*
Expand the name of the chart.
*/}}
{{- define "elasticsearch.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
*/}}
{{- define "elasticsearch.fullname" -}}
{{- $name := default .Chart.Name .Values.nameOverride -}}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a chart name
*/}}
{{- define "elasticsearch.chartname" -}}
{{- $chartVersion := .Chart.Version | replace "+" "_" -}}
{{- printf "%s-%s" .Chart.Name $chartVersion | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Defines the credential secret
*/}}
{{- define "elasticsearch.credentialsecret" -}}
credential-{{ template "elasticsearch.fullname" . }}
{{- end -}}

{{/*
Defines the registry secret
*/}}
{{- define "elasticsearch.containersecret" -}}
registry-{{ template "elasticsearch.fullname" . }}
{{- end -}}

{{/*
Defines the client service
*/}}
{{- define "elasticsearch.clientservice" -}}
client-delivery-elasticsearch-master
{{- end -}}

{{/*
Defines the headless service
*/}}
{{- define "elasticsearch.headlessservice" -}}
headless-delivery-elasticsearch-master
{{- end -}}

{{/*
Defines the image pull secret data
*/}}
{{- define "elasticsearch.imagePullSecret" }}
{{- printf "{\"%s\":{\"username\":\"%s\",\"password\":\"%s\",\"email\":\"%s\"}}" .Values.secret.container.name .Values.secret.container.user .Values.secret.container.password .Values.secret.container.email | b64enc }}
{{- end -}}