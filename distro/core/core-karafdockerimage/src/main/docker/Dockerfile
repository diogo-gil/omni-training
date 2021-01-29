FROM @docker.base@:@parsedToolingVersion.majorVersion@.@parsedToolingVersion.minorVersion@.@parsedToolingVersion.incrementalVersion@
MAINTAINER @project.organization.name@  <@mailingLists.default.post@>
# Environment variables
ENV KARAF_VERSION="@grp.karaf.version@"

USER 0

# Copy commands
COPY --chown=karaf:karaf maven /

RUN chmod -R +x /opt/apache/karaf/bin/

USER runit