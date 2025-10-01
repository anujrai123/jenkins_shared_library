def call(String playbook, String server, String action) {
    sh """
        ssh -i $SSH_KEY -o StrictHostKeyChecking=no ubuntu@${server} \
        "ansible-playbook -i '${server},' /home/ubuntu/Ansible/playbook/${playbook} --extra-vars 'action=${action}'"
    """
}
