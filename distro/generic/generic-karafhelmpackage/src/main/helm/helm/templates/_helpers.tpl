{{/* vim: set filetype=mustache: */}}
{{/*
Expand the name of the chart.
*/}}
{{- define "generic.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
*/}}
{{- define "generic.fullname" -}}
{{- $name := default .Chart.Name .Values.nameOverride -}}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a chart name
*/}}
{{- define "generic.chartname" -}}
{{- $chartVersion := .Chart.Version | replace "+" "_" -}}
{{- printf "%s-%s" .Chart.Name $chartVersion | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Defines the credential secret
*/}}
{{- define "generic.credentialsecret" -}}
credential-{{ template "generic.fullname" . }}
{{- end -}}

{{/*
Defines the init container secret
*/}}
{{- define "generic.initcontainersecret" -}}
initcontainer-{{ template "generic.fullname" . }}
{{- end -}}

{{/*
Defines the container secret
*/}}
{{- define "generic.containersecret" -}}
container-{{ template "generic.fullname" . }}
{{- end -}}

{{/*
Defines the client service
*/}}
{{- define "generic.clientservice" -}}
client-{{ template "generic.fullname" . }}
{{- end -}}

{{/*
Defines the headless service
*/}}
{{- define "generic.headlessservice" -}}
headless-{{ template "generic.fullname" . }}
{{- end -}}

{{/*
Defines the init container pull secret data
*/}}
{{- define "generic.initcontainerpullsecret" }}
{{- printf "{\"%s\":{\"username\":\"%s\",\"password\":\"%s\",\"email\":\"%s\"}}" .Values.secret.initContainer.name .Values.secret.initContainer.user .Values.secret.initContainer.password .Values.secret.initContainer.email | b64enc }}
{{- end -}}

{{/*
Defines the container pull secret data
*/}}
{{- define "generic.containerpullsecret" }}
{{- printf "{\"%s\":{\"username\":\"%s\",\"password\":\"%s\",\"email\":\"%s\"}}" .Values.secret.container.name .Values.secret.container.user .Values.secret.container.password .Values.secret.container.email | b64enc }}
{{- end -}}
