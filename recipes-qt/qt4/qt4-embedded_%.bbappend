QT_EMBEDDED_EXTRA_FLAGS_append = " -plugin-gfx-directfb"
DEPENDS_append = " directfb"

QT_CONFIG_FLAGS_remove = "-webkit -pulseaudio -linuxfb -qvfb -eglfs -system-sqlite -qt3support -plugin-sql-sqlite -plugin-gfx-qvfb -plugin-gfx-vnc -qt-mouse-qvfb -xmlpatterns"

QT_CONFIG_FLAGS_append = " -no-qt3support -no-webkit -no-audio-backend -no-qvfb -no-mouse-qvfb -no-libmng -svg -no-xmlpatterns"

# Reverse meta-freescale/dynamic-layers/qt4-layer/reciepes-qt4/qt4/qt4-imx-support.inc
# of imxgpu2d overrides, specifically for building mx8 series which are wayland based
# and intricately configured by the fsl/freescale conf files
DEPENDS_remove = "virtual/libgles2"
QT_GLFLAGS_remove = "-opengl es2 -openvg"
QT_CONFIG_FLAGS_remove = "-DEGL_API_FB=1"