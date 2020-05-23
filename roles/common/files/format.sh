#!/bin/bash
#Used to fomat 2 disks
PATH=/bin:/sbin:/usr/bin:/usr/sbin
export PATH  

usage() {
  echo "Usage: format disk mount_dir"
}
diskformat() {
  dn=$1
  echo "formating ${dn} *****/n/n"
  fdisk ${dn} <<ESXU
d
n
p
1


w
ESXU
  echo "/n/n******${dn} __was Fdisked! Waiting For 1 Second*****/n/n"  
  sleep 1s
  mkfs.xfs -f ${dn}1
  if [ "$?" = "0" ];then
          echo "/n/n*****${dn}1 _________________was Formated, Waiting For 5 Second****/n/n"  
  fi
}


#must root user
if [ "$(whoami)" != "root" ]
then
    echo "root needed ";
	exit 1
fi

if [ $# -lt 2 ];
then
    usage
    exit
fi


disk=$1
mount_dir=$2
umount /dev/${disk}1
diskformat /dev/${disk}
mkdir -p $mount_dir

grep -v ^/dev/${disk}1 /etc/fstab > /tmp/fstab
echo "/dev/${disk}1	${mount_dir}	xfs	rw,noatime,inode64,allocsize=16m	0	0" >>  /tmp/fstab
cp /tmp/fstab /etc/fstab
mount -a
#echo deadline >  /sys/block/${disk}/queue/scheduler

