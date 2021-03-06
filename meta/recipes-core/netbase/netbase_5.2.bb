SUMMARY = "Basic TCP/IP networking support"
DESCRIPTION = "This package provides the necessary infrastructure for basic TCP/IP based networking"
HOMEPAGE = "http://packages.debian.org/netbase"
SECTION = "base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=3dd6192d306f582dee7687da3d8748ab"
PE = "1"

SRC_URI = "http://downloads.yoctoproject.org/mirror/sources/netbase_${PV}.tar.gz \
           file://hosts"

SRC_URI[md5sum] = "3a01bfce6a28e1743412198abd241262"
SRC_URI[sha256sum] = "d62ba56d62b9b121664828175c2a237a7014ef32df8a4116ea33cff332de3307"

do_install () {
	install -d ${D}/${mandir}/man8 ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/hosts ${D}${sysconfdir}/hosts
	install -m 0644 etc-rpc ${D}${sysconfdir}/rpc
	install -m 0644 etc-protocols ${D}${sysconfdir}/protocols
	install -m 0644 etc-services ${D}${sysconfdir}/services
}

CONFFILES_${PN} = "${sysconfdir}/hosts"
