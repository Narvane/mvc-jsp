FROM tomcat:latest

ADD target/mvc-jsp.war /usr/local/tomcat/webapps/

EXPOSE 8080
EXPOSE 5005

CMD ["catalina.sh", "run"]