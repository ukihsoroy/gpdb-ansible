#!/bin/bash

base_dir=$(cd `dirname $0`;pwd)

cp ${base_dir}/config/hosts ${base_dir}/roles/common/files
cp ${base_dir}/config/sysctl.conf ${base_dir}/roles/common/files
cp ${base_dir}/config/limits.conf ${base_dir}/roles/common/files

export ANSIBLE_HOST_KEY_CHECKING=False
ansible-playbook ${base_dir}/deploy.yml -i $base_dir/config/control.txt

cat /tmp/pub/id_rsa_* > /tmp/pub_local

ansible-playbook ${base_dir}/pub.yml -i $base_dir/config/control.txt

