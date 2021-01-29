{{/* vim: set filetype=mustache: */}}
{{/*
Expand the name of the chart.
*/}}
{{- define "productcatalog.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
*/}}
{{- define "productcatalog.fullname" -}}
{{- $name := default .Chart.Name .Values.nameOverride -}}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a default fully qualified ingress name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
*/}}
{{- define "productcatalog.consoleingressname" -}}
{{ template "productcatalog.fullname" . }}-console
{{- end -}}

{{/*
Create chart name and version as used by the chart label.
*/}}
{{- define "productcatalog.chart" -}}
{{- printf "%s-%s" .Chart.Name .Chart.Version | replace "+" "_" | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Defines the client service
*/}}
{{- define "productcatalog.clientservice" -}}
client-delivery-productcatalog
{{- end -}}

{{/*
Defines the headless service
*/}}
{{- define "productcatalog.headlessservice" -}}
headless-delivery-productcatalog
{{- end -}}

{{/*
Defines the image pull secret data
*/}}
{{- define "productcatalog.imagePullSecret" }}
{{- printf "{\"auths\": {\"%s\": {\"auth\": \"%s\"}, \"%s\": {\"auth\": \"%s\"}}}" .Values.secret.container.name (printf "%s:%s" .Values.secret.container.user .Values.secret.container.password | b64enc) .Values.secret.initcontainer.name (printf "%s:%s" .Values.secret.initcontainer.user .Values.secret.initcontainer.password | b64enc) | b64enc }}
{{- end }}

{{/*
Create a chart name
*/}}
{{- define "productcatalog.chartname" -}}
{{- $chartVersion := .Chart.Version | replace "+" "_" -}}
{{- printf "%s-%s" .Chart.Name $chartVersion | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Defines the credential secret
*/}}
{{- define "productcatalog.credentialsecret" -}}
credential-{{ template "productcatalog.fullname" . }}
{{- end -}}

{{/*
Defines the registry secret
*/}}
{{- define "productcatalog.containersecret" -}}
registry-{{ template "productcatalog.fullname" . }}
{{- end -}}
