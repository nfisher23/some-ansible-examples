Upgrade Elasticsearch Cluster
=========

This is some sample code to go along with the tutorial at [How to do a Rolling Upgrade of an Elasticsearch Cluster Using Ansible](https://nickolasfisher.com/blog/How-to-do-a-Rolling-Upgrade-of-an-Elasticsearch-Cluster-Using-Ansible).

To begin, run

```
$ molecule create && molecule converge
```

Then, after the VMs come up and having working elasticsearch instances:

1. Change the upgrade_es flag to true in the defaults/main.yml.
2. Uncomment the `serial: 1` flag in molecule/default/playbook.yml
3. Run:

```
$ molecule converge
```

And the cluster should upgrade in place.