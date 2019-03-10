import os

import testinfra.utils.ansible_runner

testinfra_hosts = testinfra.utils.ansible_runner.AnsibleRunner(
    os.environ['MOLECULE_INVENTORY_FILE']).get_hosts('all')


def test_java_runtime(host):
    cmd = host.run("java -version")
    assert cmd.rc == 0
    assert cmd.stderr.find("11.0")


def test_java_compiler(host):
    cmd = host.run("javac -version")
    assert cmd.rc == 0
    assert cmd.stderr.find("11.0")


def test_java_home_configured(host):
    f = host.file("/etc/environment")
    assert f.contains("JAVA_HOME=/usr/lib")

