SUMMARY = "Nonsolosat Addons"
MAINTAINER = "www.nonsolosat.net"
SECTION = "base"
LICENSE = "proprietary"

require conf/license/license-gplv2.inc

inherit gitpkgv
SRCREV = "${AUTOREV}"

SRC_URI="git://github.com/NSS-SAT/nsspanel.git;protocol=https"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr/*"


do_install() {
    cp -rp ${S}/usr ${D}/
}

do_package_qa[noexec] = "1"
