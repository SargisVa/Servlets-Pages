set +e

mvn clean package

rm -rf ~/apache-tomcat-8.5.81/webapps/ROOT/
cp -r target/OnlineShop ~/apache-tomcat-8.5.81/webapps/ROOT

sh ~/apache-tomcat-8.5.81/bin/catalina.sh stop
#sh ~/apache-tomcat-8.5.81/bin/catalina.sh start