package com.example.xiaobo

import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences
    private lateinit var weatherView: WeatherView
    private lateinit var pages: List<View>
    private lateinit var navButtons: List<TextView>
    private lateinit var switchFloat: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = getSharedPreferences("demo_prefs", MODE_PRIVATE)
        weatherView = findViewById(R.id.weatherView)

        pages = listOf(
            findViewById(R.id.pageHome),
            findViewById(R.id.pageFunc),
            findViewById(R.id.pageTool),
            findViewById(R.id.pageSettings)
        )

        navButtons = listOf(
            findViewById(R.id.btnHome),
            findViewById(R.id.btnFunc),
            findViewById(R.id.btnTool),
            findViewById(R.id.btnSettings)
        )

        navButtons.forEachIndexed { index, button ->
            button.setOnClickListener { showPage(index) }
        }

        showPage(0)

        switchFloat = findViewById(R.id.switchFloat)
        switchFloat.setOnCheckedChangeListener { _, checked ->
            if (checked) {
                val coreOk = prefs.getBoolean("core_downloaded", false)
                val driverOk = prefs.getBoolean("driver_downloaded", false)

                if (!coreOk || !driverOk) {
                    Toast.makeText(this, "请先下载小铂内核和小铂驱动", Toast.LENGTH_SHORT).show()
                    switchFloat.isChecked = false
                } else {
                    showCardDialog()
                }
            } else {
                stopService(Intent(this, FloatingService::class.java))
            }
        }

        findViewById<Button>(R.id.btnCore).setOnClickListener {
            simulateDownload("core_downloaded", "小铂内核", findViewById(R.id.tvCoreStatus))
        }

        findViewById<Button>(R.id.btnTheme).setOnClickListener {
            simulateDownload("theme_downloaded", "小铂美化", findViewById(R.id.tvThemeStatus))
        }

        findViewById<Button>(R.id.btnToolDownload).setOnClickListener {
            simulateDownload("tool_downloaded", "小铂刷刀", findViewById(R.id.tvToolStatus))
        }

        findViewById<Button>(R.id.btnDriver1).setOnClickListener { applyDriver("小铂驱动") }
        findViewById<Button>(R.id.btnDriver2).setOnClickListener { applyDriver("LV驱动") }
        findViewById<Button>(R.id.btnDriver3).setOnClickListener { applyDriver("葫芦娃驱动") }

        findViewById<Button>(R.id.btnUpdate).setOnClickListener {
            Toast.makeText(this, "已是最新版本", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnThemeStyle).setOnClickListener {
            showThemeDialog()
        }
    }

    private fun showPage(index: Int) {
        pages.forEachIndexed { i, view ->
            view.visibility = if (i == index) View.VISIBLE else View.GONE
        }

        navButtons.forEachIndexed { i, button ->
            button.setTextColor(if (i == index) Color.WHITE else Color.parseColor("#AAFFFFFF"))
            button.setBackgroundResource(if (i == index) R.drawable.bg_button else 0)
        }
    }

    private fun simulateDownload(key: String, name: String, status: TextView) {
        status.text = "正在下载中..."
        Handler(Looper.getMainLooper()).postDelayed({
            prefs.edit().putBoolean(key, true).apply()
            status.text = "下载成功"
            Toast.makeText(this, "$name 下载成功", Toast.LENGTH_SHORT).show()
        }, 1500)
    }

    private fun applyDriver(name: String) {
        AlertDialog.Builder(this)
            .setTitle(name)
            .setMessage("小铂牛逼666")
            .setPositiveButton("确定") { _, _ ->
                prefs.edit().putBoolean("driver_downloaded", true).apply()
                Toast.makeText(this, "刷入成功", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    private fun showCardDialog() {
        val input = EditText(this)
        input.hint = "请输入卡密"
        input.inputType = InputType.TYPE_CLASS_NUMBER

        val dialog = AlertDialog.Builder(this)
            .setTitle("卡密验证")
            .setView(input)
            .setPositiveButton("验证", null)
            .setNegativeButton("取消") { _, _ ->
                switchFloat.isChecked = false
            }
            .create()

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                if (input.text.toString() == "789122") {
                    prefs.edit().putString("expire", "7891年").apply()
                    Toast.makeText(this, "到期时间：7891年", Toast.LENGTH_LONG).show()
                    dialog.dismiss()
                    openOverlay()
                } else {
                    Toast.makeText(this, "卡密错误", Toast.LENGTH_SHORT).show()
                    switchFloat.isChecked = false
                }
            }
        }

        dialog.show()
    }

    private fun openOverlay() {
        if (!Settings.canDrawOverlays(this)) {
            Toast.makeText(这, "请授予悬浮窗权限", Toast.LENGTH_SHORT).show()
            startActivity(
                Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
Uri.parse（[包:$packageName]）
                )
            )
isChecked=虚假的
返回
        }

值=you you you you you：. java）
如果（Build.VERSION.SDK_INT>=Build.VERSION_CODES.O）{
            startForegroundService(intent)
} 其他的 {
            startService(intent)
        }

makeText这，"悬浮窗已开启", Toast.LENGTH_SHORT).show()
    }

私人的展示你的meDialog（）{
值=blorebookleadyou
定向=LinearLayout.
            setPadding(40, 40, 40, 40)
        }

值=youryou）. apply{text="雪花飘落" }
值=youryou）. apply{text="下雨" }

        layout.addView(snow)
        layout.addView(rain)

值=biortallog.Builder（）
            .setTitle("主题风格")
            .setView(layout)
            .create()

snow.setOnClickListener {
            weatherView.visibility = View.VISIBLE
            weatherView.mode = WeatherView.Mode.SNOW
            dialog.dismiss()
        }

        rain.setOnClickListener {
            weatherView.visibility = View.VISIBLE
            weatherView.mode = WeatherView.Mode.RAIN
            dialog.dismiss()
        }

        dialog.show()
    }
}
