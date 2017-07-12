# Copyright (C) 2015, 2016 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel for JCI Q6 Board"
DESCRIPTION = "Linux kernel based on NXP 4.1.15-1.2.0 GA release, used by FSL Community BSP in order to \
provide support for i.MX based platforms and include official Linux kernel stable updates, backported \
features and fixes coming from the vendors, kernel community or FSL Community itself."

# Note: Inserted linux-fslc.inc directly in file here

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

#PV .= "+git${SRCPV}"
PV .= ""

SRCBRANCH = "krogoth"
LOCALVERSION = "-yocto"

SRC_URI = "git://github.com/itgembedded/jciq6-linux-v4.1.git;branch=${SRCBRANCH} \
           file://defconfig"

#SRCREV is the commit number, must always be updated for each new version
SRCREV = "257dfebcd8b41508c24abdc3ca97928c3acd2f63"

COMPATIBLE_MACHINE = "(mx6|mx7|imx6q-jciq6)"
