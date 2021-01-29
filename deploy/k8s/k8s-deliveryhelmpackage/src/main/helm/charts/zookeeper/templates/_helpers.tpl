{{/* vim: set filetype=mustache: */}}
{{/*
Expand the name of the chart.
*/}}
{{- define "zookeeper.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
*/}}
{{- define "zookeeper.fullname" -}}
{{- $name := default .Chart.Name .Values.nameOverride -}}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a chart name
*/}}
{{- define "zookeeper.chartname" -}}
{{- $chartVersion := .Chart.Version | replace "+" "_" -}}
{{- printf "%s-%s" .Chart.Name $chartVersion | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Defines the credential secret
*/}}
{{- define "zookeeper.credentialsecret" -}}
credential-{{ template "zookeeper.fullname" . }}
{{- end -}}

{{/*
Defines the registry secret
*/}}
{{- define "zookeeper.containersecret" -}}
registry-{{ template "zookeeper.fullname" . }}
{{- end -}}

{{/*
Defines the client service
*/}}
{{- define "zookeeper.clientservice" -}}
client-delivery-zookeeper
{{- end -}}

{{/*
Defines the headless service
*/}}
{{- define "zookeeper.headlessservice" -}}
headless-delivery-zookeeper
{{- end -}}

{{/*
Defines the image pull secret data
*/}}
{{- define "zookeeper.imagePullSecret" }}
{{- printf "{\"%s\":{\"username\":\"%s\",\"password\":\"%s\",\"email\":\"%s\"}}" .Values.secret.container.name .Values.secret.container.user .Values.secret.container.password .Values.secret.container.email | b64enc }}
{{- end -}}