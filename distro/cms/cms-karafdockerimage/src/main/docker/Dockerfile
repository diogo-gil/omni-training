FROM @docker.base@:@parsedToolingVersion.majorVersion@.@parsedToolingVersion.minorVersion@.@parsedToolingVersion.incrementalVersion@
MAINTAINER @project.organization.name@  <@mailingLists.default.post@>
# Environment variables
ENV KARAF_VERSION="@grp.karaf.version@"
ENV LC_ALL C
# Copy commands

USER 0

# Copy commands
COPY --chown=karaf:karaf maven /

COPY --chown=karaf:karaf  org.apache.jackrabbit.oak.segment.SegmentNodeStoreService.config /opt/apache/karaf/etc/

RUN chmod -R +x /opt/apache/karaf/bin/

# Install Opencv 3.2 dependencies
RUN apk add --update --no-cache ca-certificates icu-libs leptonica tesseract-ocr libjpeg libpng libwebp tiff openblas protobuf && apk add --update --update-cache ca-certificates --repository http://dl-4.alpinelinux.org/alpine/v3.9/main/ jasper

USER runit