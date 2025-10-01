def call(string url, string branch)
{
    echo "Cloning the file from git"
    git url: "${url}", branch: "${branch}"
    echo "Code cloning is done"

}