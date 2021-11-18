SUMMARY = "Portal app"

SRC_URI = "git://git@bitbucket.org/getportal/sensortest.git;protocol=ssh"

SRCREV = "b6e0039b26be680a36d217d76a1447ebe21aadb7"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}/git"

DEPENDS = "openframeworks"

RDEPENDS_${PN} = " zbar openframeworks opencv libudev "
FILES_${PN} = "/opt/portal"

inherit pkgconfig

#do_compile[noexec] = "1"

EXTRA_OEMAKE = "\
        PLATFORM_ARCH=${TARGET_ARCH} \
        RECIPE_SYSROOT=${RECIPE_SYSROOT} \
        PROJECT_OPTIMIZATION_CFLAGS_RELEASE="" \
	OF_ROOT=${RECIPE_SYSROOT}/usr/share/openFrameworks \
"

do_install(){
	#mkdir -p ${S}/lib/
	#tar -xf ${S}/libs.tar.gz -C ${S}/lib/

	#mkdir -p ${S}/addons/
	#tar -xf ${S}/addons.tar.gz -C ${S}/addons/

	#install -m 0755 -d ${D}/root/
	#cp -r ${S}/lib/* ${D}/root/

	install -m 0755 -d ${D}/opt/portal
	cp -r ${S}/bin/* ${D}/opt/portal
}
