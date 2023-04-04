SUMMARY = "External Linux kernel module for audio codec tfa98xx on voicehat"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d2f18c7c8390c6dc7f1db6b14bbb1f0a"

FILESEXTRAPATHS_prepend := "$THISDIR}/${PN}:"

inherit module

SRCREV = "8bf1e8de411308587f5c0e4567185512e1097753"
SRCBRANCH = "tn-DIN_v6x"
SRC_URI = "git://github.com/TechNexion/tfa98xx.git;branch=${SRCBRANCH} \
           https://github.com/nxp-imx-support/meta-avs-demos/tree/imx-alexa-sdk/recipes-kernel/tfa98xx/files/TFA9892N1A_stereo_32FS.cnt;downloadfilename=TFA9892N1A_stereo_32FS.cnt \
"

SRC_URI[md5sum] = "dc2b2583e0d7a7d31e3c89f59550264c"
SRC_URI[sha256sum] = "178f3452081b2b5e5e9859de623fdcc1b0d4e0b457e496b0132d98d8d43a6978"

S = "${WORKDIR}/git"

EXTRA_OEMAKE += "KDIR='${STAGING_KERNEL_DIR}'"

do_install_append() {
	install -d -m 0755 ${D}/lib/firmware/tfa98/9912/
	install -m 0444 ${WORKDIR}/TFA9892N1A_stereo_32FS.cnt ${D}/lib/firmware/tfa98/9912/
	ln -sf ./tfa98/9912/TFA9892N1A_stereo_32FS.cnt ${D}/lib/firmware/tfa98xx.cnt
}

FILES_${PN} += "/lib/firmware/"
BBCLASSEXTEND = "native"

KERNEL_MODULE_AUTOLOAD += "snd-soc-tfa98xx"
RPROVIDES_${PN} += "kernel-module-tfa98xx"

COMPATIBLE_MACHINE = "mx6|mx7|mx8"
