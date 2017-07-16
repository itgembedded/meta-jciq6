# Note: Inserted u-boot-fslc.inc into beginning of this file directly

# Copyright (C) 2012-2016 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-bsp/u-boot/u-boot.inc

inherit fsl-u-boot-localversion

DEPENDS_mxs += "elftosb-native openssl-native"


SUMMARY = "U-Boot bootloader with support for Q6 board"
DESCRIPTION = "U-Boot based on mainline U-Boot used by FSL Community BSP in \
order to provide support for some backported features and fixes, or because it \
was submitted for revision and it takes some time to become part of a stable \
version, or because it is not applicable for upstreaming."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"
# COMPATIBLE_MACHINE = "(mxs|mx5|mx6|mx6ul|mx7|vf)"
COMPATIBLE_MACHINE = "(mxs|mx5|mx6|mx6ul|mx7|vf|imx6q-jciq6|jciq6)"

PROVIDES += "u-boot"
PROVIDES += "u-boot-jciq6"

PV = "v2016.07+git${SRCPV}"

SRCBRANCH ??= "krogoth"

SRC_URI = "git://github.com/itgembedded/jciq6-uboot-v2016.07.git;branch=${SRCBRANCH}"

#SRCREV is the commit number, must be always changed for a new version
SRCREV = "a7dd9476a20111decd8d57e47620476df9e24522"

S = "${WORKDIR}/git"

# FIXME: Allow linking of 'tools' binaries with native libraries
#        used for generating the boot logo and other tools used
#        during the build process.
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="${BUILD_LDFLAGS}" \
                 HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"

# end of u-boot-jciq6_2017.07.bb


