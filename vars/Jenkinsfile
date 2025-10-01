@Library("Shared") _

pipeline {
    agent any

    parameters {
        choice(name: 'ACTION', choices: ['precheck', 'install', 'uninstall'], description: 'Select action to perform')
        string(name: 'SERVER_NAME', defaultValue: '13.234.202.169', description: 'Target server IP')
    }

    stages {

        stage('Print Inputs') {
            steps {
                script {
                    echo "Selected Action: ${params.ACTION}"
                    echo "Target Server: ${params.SERVER_NAME}"
                }
            }
        }

        stage('Setup Credentials') {
            steps {
                script {
                    // Using your shared library credentials.groovy
                    credentials("ansible-ssh-key") {
                        echo "SSH credentials loaded and key available at \$SSH_KEY"
                    }
                }
            }
        }

        stage('Run Ansible Playbook') {
            steps {
                script {
                    // Using your shared library ansible.groovy
                    credentials("ansible-ssh-key") {
                        ansible("install_jenkins.yml", params.SERVER_NAME, params.ACTION)
                    }
                }
            }
        }

        stage('Post Actions') {
            steps {
                script {
                    echo "Pipeline finished successfully for ${params.SERVER_NAME} with action ${params.ACTION}"
                }
            }
        }
    }
}
