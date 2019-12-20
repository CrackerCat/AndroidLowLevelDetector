package net.imknown.android.forefrontinfo

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.ProgressCallback
import com.github.kittinunf.fuel.coroutines.awaitByteArrayResult
import com.github.kittinunf.fuel.coroutines.awaitStringResult
import com.github.kittinunf.fuel.httpDownload
import com.github.kittinunf.fuel.httpGet
import java.io.File
import java.util.*

class GatewayApi {
    companion object {
        const val LLD_JSON_NAME = "lld.json"

        private const val URL_LLD_JSON_ZH_CN =
            "https://gitee.com/imknown/AndroidLowLevelDetector/raw/master/app/src/main/assets/$LLD_JSON_NAME"

        private const val URL_LLD_JSON =
            "https://raw.githubusercontent.com/imknown/AndroidLowLevelDetector/master/app/src/main/assets/$LLD_JSON_NAME"

        private const val URL_GITHUB_CHECK_FOR_UPDATE =
            "https://api.github.com/repos/imknown/AndroidLowLevelDetector/releases/latest"

        const val DIR_APK = "Apk"

        lateinit var savedLldJsonFile: File

        suspend fun downloadLldJsonFile(
            success: (ByteArray) -> Unit,
            failure: (FuelError) -> Unit
        ) {
            val url = if (isChinaMainlandTimezone()) {
                URL_LLD_JSON_ZH_CN
            } else {
                URL_LLD_JSON
            }

            url.httpDownload().fileDestination { _, _ -> savedLldJsonFile }
                .awaitByteArrayResult().fold(success, failure)
        }

        suspend fun checkForUpdate(
            success: (String) -> Unit,
            failure: (FuelError) -> Unit
        ) {
            val url = URL_GITHUB_CHECK_FOR_UPDATE
            url.httpGet().awaitStringResult().fold(success, failure)
        }

        suspend fun downloadApk(
            url: String,
            fileName: String,
            progressCallback: ProgressCallback,
            success: (ByteArray) -> Unit,
            failure: (FuelError) -> Unit
        ) {
            url.httpDownload()
                .fileDestination { _, _ ->
                    clearFolder(MyApplication.getApkDir())
                    MyApplication.getApkDir().mkdirs()
                    File(MyApplication.getApkDir(), fileName)
                }
                .responseProgress(progressCallback)
                .awaitByteArrayResult().fold(success, failure)
        }

        fun clearFolder(dir: File): Boolean {
            if (!dir.exists()) {
                return true
            }

            return dir.deleteRecursively()
        }

        private fun isZhCn(): Boolean {
            val lD = Locale.getDefault()
            val lSC = Locale.SIMPLIFIED_CHINESE
            return (lD.language == lSC.language && lD.country == lSC.country)
        }

        private fun isChinaMainlandTimezone() =
            TimeZone.getDefault().id == "Asia/Shanghai" || TimeZone.getDefault().id == "Asia/Urumqi"
    }
}