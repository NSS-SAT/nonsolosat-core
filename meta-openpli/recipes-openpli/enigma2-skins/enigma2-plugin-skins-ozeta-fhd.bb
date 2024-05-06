SUMMARY = "nonsolosat skins"
MAINTAINER = "www.nonsolosat.net"
SECTION = "base"
LICENSE = "proprietary"


require conf/license/license-gplv2.inc

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "7.5+git${SRCPV}"
PKGV = "7.5+git${GITPKGV}"
VER ="1.0"
PR = "r4"

SRC_URI="git://github.com/NSS-SAT/skins-ozeta-fhd.git;protocol=https"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr/*"


do_install() {
    cp -rp ${S}/usr ${D}/
}

do_package_qa[noexec] = "1"
