timeout(60){
    node("maven"){
        timestamps {

                stage("checkout") {
                    checkout scm
                }

                stage("Running tests") {
                    def exitCode = sh(
                            returnStatus: true,
                            script: " mvn test -DplatformName=${PLATFORM_NAME} -DdeviceName=${DEVICE_NAME} -DplatformVersion=${PLATFORM_VERSION} -DaddressServer=${ADDRESS_SERVER}"
                    )
                    if (exitCode == 1) {
                        currentBuild.result = 'UNSTABLE'
                    }
                }
                stage("Allure report") {
                    allure([
                            invludeProperties: false,
                            jdk              : '',
                            properties       : [],
                            reportBuildPolicy: 'ALWAYS',
                            results          : [[path: './allure-results']]
                    ])
                }


        }
    }
}