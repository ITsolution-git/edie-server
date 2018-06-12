 @Library('sr') _
javaBuild {
    name='eddieui-server'
    exposedport='6009'
    devbranch='dev'
    registry='nexus-dev.securegion.com'
    registryport='18079'
    dockerrun="--name ${name} -d -p ${exposedport}:8080 " +
            "-e SPRING_PROFILES_ACTIVE=container " +
            "--restart=unless-stopped ${registry}:${registryport}/${name}"
}