timeout(60){
    node("maven"){
        timestamps {

                stage("checkout") {
                    checkout scm
                }

                stage("Running tests") {
                    def exitCode = sh(
                            returnStatus: true,
                            script: " mvn test -DBase.url=${BASE_URL}"
                    )
                    if (exitCode == 1) {
                        currentBuild.result = 'UNSTABLE'
                    }
                }
                /*stage("Allure report") {
                    allure([
                            invludeProperties: false,
                            jdk              : '',
                            properties       : [],
                            reportBuildPolicy: 'ALWAYS',
                            results          : [[path: './target/allure-results']]
                    ])
                }*/


        }
    }
}