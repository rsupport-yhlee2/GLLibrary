package com.example.gllibrary

import android.opengl.GLES11Ext
import android.opengl.GLES20
import android.opengl.GLES30.*
import java.nio.IntBuffer

class CameraTexture {
    private var id: Int? = null

    fun getId() = id ?: throw IllegalStateException("Call load() before using texture")

    fun load() {
        if (id != null) {
            return
        }

        val id = IntBuffer.allocate(1)
        glGenTextures(1, id)
        id[0].also {
            this.id = it
            glBindTexture(GL_TEXTURE_2D, it)
        }
        glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, getId())
        glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE)
        glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE)
        glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, GL_TEXTURE_MIN_FILTER, GL_NEAREST)
        glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, GL_TEXTURE_MAG_FILTER, GL_NEAREST)

    }
}