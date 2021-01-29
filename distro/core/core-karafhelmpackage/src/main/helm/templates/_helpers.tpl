{{/* vim: set filetype=mustache: */}}
{{/*
Expand the name of the chart.
*/}}
{{- define "core.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
*/}}
{{- define "core.fullname" -}}
{{- $name := default .Chart.Name .Values.nameOverride -}}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a chart name
*/}}
{{- define "core.chartname" -}}
{{- $chartVersion := .Chart.Version | replace "+" "_" -}}
{{- printf "%s-%s" .Chart.Name $chartVersion | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Defines the credential secret
*/}}
{{- define "core.credentialsecret" -}}
credential-{{ template "core.fullname" . }}
{{- end -}}

{{/*
Defines the init container secret
*/}}
{{- define "core.initcontainersecret" -}}
initcontainer-{{ template "core.fullname" . }}
{{- end -}}

{{/*
Defines the container secret
*/}}
{{- define "core.containersecret" -}}
container-{{ template "core.fullname" . }}
{{- end -}}

{{/*
Defines the client service
*/}}
{{- define "core.clientservice" -}}
client-{{ template "core.fullname" . }}
{{- end -}}

{{/*
Defines the headless service
*/}}
{{- define "core.headlessservice" -}}
headless-{{ template "core.fullname" . }}
{{- end -}}

{{/*
Defines the init container pull secret data
*/}}
{{- define "core.initcontainerpullsecret" }}
{{- printf "{\"%s\":{\"username\":\"%s\",\"password\":\"%s\",\"email\":\"%s\"}}" .Values.secret.initContainer.name .Values.secret.initContainer.user .Values.secret.initContainer.password .Values.secret.initContainer.email | b64enc }}
{{- end -}}

{{/*
Defines the container pull secret data
*/}}
{{- define "core.containerpullsecret" }}
{{- printf "{\"%s\":{\"username\":\"%s\",\"password\":\"%s\",\"email\":\"%s\"}}" .Values.secret.container.name .Values.secret.container.user .Values.secret.container.password .Values.secret.container.email | b64enc }}
{{- end -}}