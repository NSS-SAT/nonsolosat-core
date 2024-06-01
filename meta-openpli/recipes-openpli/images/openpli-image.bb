require conf/license/openpli-gplv2.inc

inherit image

DEPENDS += " \
	zip-native \
"

IMAGE_INSTALL = "\
	${ROOTFS_PKGMANAGE} \
	3rd-party-feed-configs \
	avahi-daemon \
	busybox-cron \
	ca-certificates \
	distro-feed-configs \
	dropbear \
	e2fsprogs-e2fsck \
	e2fsprogs-mke2fs \
	e2fsprogs-tune2fs \
	fakelocale \
	fuse-exfat \
	kernel-params \
	modutils-loadscript \
	cifs-utils \
	nfs-utils \
	nfs-utils-client \
	openpli-bootlogo \
	openssh-sftp-server \
	opkg \
	util-linux-mount \
	packagegroup-base \
	packagegroup-core-boot \
	parted \
	${PYTHON_PN}-ipaddress  \
	${PYTHON_PN}-netifaces \
	${PYTHON_PN}-pysmb \
	samba-base \
	sdparm \
	tuxbox-common \
	tzdata \
	volatile-media \
	vsftpd \
	libcrypto-compat \
	libxcrypt-compat \
	${PYTHON_PN}-unixadmin \
	${PYTHON_PN}-requests \
	${PYTHON_PN}-imaging \
	${PYTHON_PN}-image \
	${PYTHON_PN}-multiprocessing \
	${PYTHON_PN}-chardet  \
	${PYTHON_PN}-certifi \
	${PYTHON_PN}-pysocks \
	${PYTHON_PN}-urllib3 \
	${PYTHON_PN}-websocket-client \
	${PYTHON_PN}-isodate \
	${PYTHON_PN}-pycryptodome \
	${PYTHON_PN}-ipaddress \
	${PYTHON_PN}-fuzzywuzzy \
	${PYTHON_PN}-levenshtein \
	${PYTHON_PN}-six \
	${PYTHON_PN}-cryptography \
        ${PYTHON_PN}-pycurl \
	${PYTHON_PN}-compression \
        ${PYTHON_PN}-dateutil \
        ${PYTHON_PN}-rarfile \
	uchardet \
        curl \
        ffmpeg \
        openvpn \
        ${PYTHON_PN}-mechanize \
        ${PYTHON_PN}-sqlite3 \
        f4mdump \
        ${PYTHON_PN}-gdata \
        ${PYTHON_PN}-youtube-dl \
        wget \
        rtmpdump \
        duktape \
        dosfstools \
        hlsdl \
        gst-ifdsrc \
        lsdir \
        libavutil \
        libswresample \
        libavcodec \
        libbluray \
        libavformat \
        libavresample \
        libpostproc \
        libswscale \
        libavfilter \
        libavdevice \
        libicudata \
        libicuuc \
        libudev \
        zip \
        mtd-utils \
        iproute2 \
"

IMAGE_INSTALL_append_libc-glibc = " glibc-binary-localedata-en-gb"

export IMAGE_BASENAME = "nonsolosat"
IMAGE_LINGUAS = ""
IMAGE_FEATURES += "package-management"

# Remove the mysterious var/lib/opkg/lists that appears to be the result
# of the installer that populates the rootfs. I wanted to call this
# rootfs_remove_opkg_leftovers but that fails to parse.
rootfs_removeopkgleftovers() {
	rm -r ${IMAGE_ROOTFS}/var/lib/opkg/lists
}

# Some features in image.bbclass we do NOT want, so override them
# to be empty. We want to log in as root, but NOT via SSH. So we want
# to live without debug-tweaks...
zap_root_password () {
	true
}

ssh_allow_empty_password () {
	true
}

license_create_manifest() {
}

ROOTFS_POSTPROCESS_COMMAND += "rootfs_removeopkgleftovers; "
