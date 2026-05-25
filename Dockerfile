FROM tomcat:latest
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./bankmanagementapp1.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh", "run"]
