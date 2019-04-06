Upgrade Logstash
===============

The corresponding blog post for this playbook can be found at [How to do a Rolling Upgrade of Multiple Logstash Instances Using Ansible](https://nickolasfisher.com/blog/How-to-do-a-Rolling-Upgrade-of-Multiple-Logstash-Instances-Using-Ansible)

To use this playbook, first run

```
$ molecule create && molecule converge
```

After logstash is provisioned on both vms, uncomment the `serial: 1` line in molecule/default/playbook.yml, then change the upgrade_ls inventory parameters in /molecule/default/molecule.yml to true.

After the above steps are completed, run:

```
$ molecule converge
```

And it will update.

Note that with this approach the ansible playbooks are not really idempotent, which is a shame--something like a blue-green deployment would be more maintainable in the long run, but this might be more appropriate depending on your situation.