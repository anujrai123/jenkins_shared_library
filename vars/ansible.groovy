def call(String playbook, String server, String action) {
    sh """
        ssh -i $SSH_KEY -o StrictHostKeyChecking=no ubuntu@13.232.73.249 \
        "ansible-playbook -i '${server},' /home/ubuntu/Ansible/playbook/${playbook} --extra-vars 'action=${action}'"
    """
}
