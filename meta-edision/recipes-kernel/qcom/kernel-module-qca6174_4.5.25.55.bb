SUMMARY = "Qualcomm WiFi driver for QCA module 6174"
LICENSE = "BSD & GPLv2"
LIC_FILES_CHKSUM = "file://Android.mk;md5=235cc8d87e0fb1c956be4af0d07074fb"

inherit module

COMPATIBLE_MACHINE = "osmio4k|osmio4kplus"

#SRC_URI = "https://git.codelinaro.org/clo/external-wlan/qcacld-2.0/-/archive/v${PV}/qcacld-2.0.tar.gz;subdir=qcacld \
#    file://qcacld-2.0-support.patch \
#"

SRC_URI = " \
    git://git.codelinaro.org/clo/external-wlan/qcacld-2.0.git;tag=v${PV};nobranch=1;protocol=https \
    file://qcacld-2.0-support.patch \
"

SRC_URI[md5sum] = "37994d1525d20022113b5325a3aa86d5"
SRC_URI[sha256sum] = "eecac4665d8db865bccc9ae9f90c11b686deb6a17295ee23fbc9fbc71519b50e"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra
    install -m 0644 ${S}/wlan.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra

    install -d -m 0755 ${D}${sysconfdir}/modules-load.d
    echo wlan > ${D}${sysconfdir}/modules-load.d/wlan.conf
}

python do_package_prepend() {
    d.prependVar('PKGV', '-')
    d.prependVar('PKGV', d.getVar("KERNEL_VERSION", True).split("-")[0])
}

FILES_${PN} += "${sysconfdir}/modules-load.d/wlan.conf"
