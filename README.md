# greenplum ansible 部署脚本

### 参考
	https://blog.csdn.net/zutsoft/article/details/103645796
	下载地址:
	https://network.pivotal.io/products/pivotal-gpdb

	参考文档:
	https://gpdb.docs.pivotal.io/6-4/main/index.html

	安装部署：
	https://gpdb.docs.pivotal.io/6-4/install_guide/install_guide.html

### 系统参数
#### 更换版本
	拷贝相应的rpm到此文件夹
	gpdb-ansible/roles/gpdb/files
	更改
	deploy.yml 的gpdbrpm 变量
#### 可更改参数
	下面参数需要手工设置
	gppasswd: "gpadmin1234"
    gpsegdir: ["/hadoop/gp/primary","/hadoop/gp/mirror"]
    gpmasterdir: ["/hadoop/gp/master"]
	

### 注意事项
	系统初始化后，会自动创建gpadmin用户，并配置免密和安装必要软件
	1. 编辑hosts文件，此文件会同步到所有主机
	2. 编辑control.txt 文件， ansible根据此文件进行分布式操作
	3. sysctl.conf和limits.conf 可以根据实际情况参考 https://gpdb.docs.pivotal.io/6-4/install_guide/prep_os.html#topic_sqj_lt1_nfb 进行更改
	4. gpadmin 操作系统用户密码默认为gpadmin123  (可以对 deploy.yml gppasswd 进行更改设置)
	5. 对于磁盘挂载需要手工处理(代码中有format.sh 可以对盘进行自动格式化)

### 系统初始化
	1. 执行 install.sh  
	2. 重启所有主机(可以不用重启)	
	
### 进行greenplum 安装

	gpadmin 用户操作
	cp /usr/local/greenplum-db/docs/cli_help/gpconfigs/gpinitsystem_config   .
	gpinitsystem -c /home/gpadmin/gpconfigs/gpinitsystem_config -h seg_host -D
	添加环境变量到gpadmin 用户
	export MASTER_DATA_DIRECTORY=/data/master/gpseg-1
	psql -d postgres
	
## 常用命令

### 新建用户
	CREATE ROLE dev1 WITH LOGIN;
	ALTER ROLE dev1 WITH PASSWORD 'dev1';
	
	
	/hadoop/gp/master/gpseg-1/pg_hba.conf
	host     citic       dev1         10.0.0.0/8   md5
	gpstop -u
	psql -U dev1 -W -d citic -h 192.168.10.141

### 管理命令

	gpcheck
	gpcheckperf
	gpdeletesystem
	gpinitstandby
	gppkg

## 安装过程中的重要参数

* gp_interconnect_type
* shared_buffer
* gp_vmem_protect_limit

## 问题记录

	gpcondump -x citic  不能发送邮件，需要手工安装 	yum -y install mailx