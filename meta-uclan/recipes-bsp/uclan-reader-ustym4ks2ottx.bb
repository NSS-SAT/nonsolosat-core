SUMMARY = "libreader for uclan Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} = "libsdl"

COMPATIBLE_MACHINE = "ustym4ks2ottx"

SRCDATE = "20230217"

PV = "${SRCDATE}"
PR = "r0"

SRC_URI = "http://define-sw.dyndns.tv/openatv/openpli/${MACHINE}-libreader-${SRCDATE}.tar.gz"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/libreader ${D}/${bindir}
}

do_package_qa() {
}

FILES_${PN}  = "${bindir}/libreader"

SRC_URI[md5sum] = "13ff947017ec392986517fa2c033d63e"
SRC_URI[sha256sum] = "8e50d896ebc87a3b041002774820f704b6dcbe36deb73316306c49ed2a36ce01"
