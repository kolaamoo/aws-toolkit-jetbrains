package com.amazonaws.intellij.core.region

import com.amazonaws.regions.Region
import com.amazonaws.regions.RegionUtils
import com.amazonaws.regions.Regions
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

/**
 * Created by zhaoxiz on 7/20/17.
 */
data class AwsRegion(val id: String, val name: String, val icon: Icon) {
    private companion object {
         val UNKNOWN_REGION_FLAG = "/icons/aws-box.gif"
         val REGION_FLAG_MAPPING = hashMapOf<String, String>(
                 "us-east-1" to "/icons/flags/us.png",
                 "us-east-2" to "/icons/flags/us.png",
                 "us-west-1" to "/icons/flags/us.png",
                 "us-west-2" to "/icons/flags/us.png",
                 "ap-northeast-1" to "/icons/flags/japan.png",
                 "ap-southeast-1" to "/icons/flags/singapore.png",
                 "ap-southeast-2" to "/icons/flags/australia.png",
                 "eu-west-1" to "/icons/flags/ireland.png",
                 "eu-central-1" to "/icons/flags/eu.png",
                 "eu-west-2" to "/icons/flags/eu.png"
        )
    }

    constructor(id: String, name: String):
            this(id, name, IconLoader.getIcon (if (REGION_FLAG_MAPPING.get(id) == null) UNKNOWN_REGION_FLAG else REGION_FLAG_MAPPING.get(id) as String))

    override fun toString(): String {
        return name
    }

    fun isServiceSupported(serviceId: String): Boolean {
        return RegionUtils.getRegion(id).isServiceSupported(serviceId)
    }
}