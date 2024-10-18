pipeline{

    agent any
    tools {

        maven 'maven_3_9_6'
    }
    stages {
        stage('Compile') {
            steps {
                // Ejecuta las tareas de compilación con Maven
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                // Ejecuta las pruebas con Maven
                sh 'mvn clean verify -Dcucumber'
            }
        }
        // Otras etapas del pipeline

        stage('Cucumber Reports'){
            steps{
                cucumber buildStatus: "UNSTABLE",
                        fileIncludePattern: "**/cucumber.json",
                        jsonReportDirectory: 'target'
            }
        }

    }

}