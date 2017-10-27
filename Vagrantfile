Vagrant.configure("2") do |config|

config.vm.box = "centos/7"
config.vm.box_version="1708.01"
config.vm.box_check_update=false
config.ssh.insert_key=false
config.ssh.forward_agent=true
config.vm.synced_folder ".", "/home/vagrant/sync", type: "virtualbox"
config.vm.provider "virtualbox" do |vbox|
    vbox.memory = 1024
    vbox.cpus = 1
end

	config.vm.define "vagrant-docker-demo" do |machine|
	machine.vm.hostname = "demo"
	machine.vm.network "forwarded_port", guest: 8761, host: 8761
	machine.vm.network "forwarded_port", guest: 8080, host: 8080
	machine.ssh.forward_agent = true
	config.vm.provision "shell", path: "provision.sh"
	end
end
