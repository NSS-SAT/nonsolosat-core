SUMMARY = "blindscan for Uclan Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "virtual/blindscan-dvbs"

SRCDATE = "20230217"

PV = "${SRCDATE}"
PR = "r0"

SRC_URI  = "http://define-sw.dyndns.tv/openatv/openpli/${MACHINE}-blindscan-${SRCDATE}.zip"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/uclan-blindscan ${D}/${bindir}
}

do_package_qa() {
}

FILES_${PN}  = "${bindir}/uclan-blindscan"

SRC_URI[md5sum] = "3bd15408ccafffc5752b6bfe874a2fc6"
SRC_URI[sha256sum] = "4d8996c90cb957711c241c292d62dcdeaecf3d2aacc1281148a66f0517580fb9"

do_prepare_recipe_sysroot[noexec] = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
do_compile[noexec] = "1"
deltask do_populate_sysroot
