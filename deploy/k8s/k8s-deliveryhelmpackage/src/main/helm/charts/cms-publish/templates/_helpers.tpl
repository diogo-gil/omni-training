{{/* vim: set filetype=mustache: */}}
{{/*
Expand the name of the chart.
*/}}
{{- define "cms.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
*/}}
{{- define "cms.fullname" -}}
{{- $name := default .Chart.Name .Values.nameOverride -}}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a chart name
*/}}
{{- define "cms.chartname" -}}
{{- $chartVersion := .Chart.Version | replace "+" "_" -}}
{{- printf "%s-%s" .Chart.Name $chartVersion | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Defines the credential secret
*/}}
{{- define "cms.credentialsecret" -}}
credential-{{ template "cms.fullname" . }}
{{- end -}}

{{/*
Defines the init container secret
*/}}
{{- define "cms.initcontainersecret" -}}
initcontainer-{{ template "cms.fullname" . }}
{{- end -}}

{{/*
Defines the container secret
*/}}
{{- define "cms.containersecret" -}}
container-{{ template "cms.fullname" . }}
{{- end -}}

{{/*
Defines the client service
*/}}
{{- define "cms.clientservice" -}}
client-delivery-cms-publish
{{- end -}}

{{/*
Defines the headless service
*/}}
{{- define "cms.headlessservice" -}}
headless-delivery-cms-publish
{{- end -}}

{{/*
Defines the init container pull secret data
*/}}
{{- define "cms.initcontainerpullsecret" }}
{{- printf "{\"%s\":{\"username\":\"%s\",\"password\":\"%s\",\"email\":\"%s\"}}" .Values.secret.initContainer.name .Values.secret.initContainer.user .Values.secret.initContainer.password .Values.secret.initContainer.email | b64enc }}
{{- end -}}

{{/*
Defines the container pull secret data
*/}}
{{- define "cms.containerpullsecret" }}
{{- printf "{\"%s\":{\"username\":\"%s\",\"password\":\"%s\",\"email\":\"%s\"}}" .Values.secret.container.name .Values.secret.container.user .Values.secret.container.password .Values.secret.container.email | b64enc }}
{{- end -}}
