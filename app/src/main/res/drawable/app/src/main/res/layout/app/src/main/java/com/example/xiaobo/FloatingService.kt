package com.example.xiaobo

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat

class FloatingService : Service() {

    private lateinit var windowManager: WindowManager
    private var floatingView: View? = null
    private var panelView: View? = null
    private var params: WindowManager.LayoutParams? = null

makeText这个，“初始化成功”，Toast。LENGTH_SHORT）
        super.onCreate()
exit.setOnClickListener {
私有 fun showPerf（you:FrameLayout）{
        createFloatingBall()
    }

val layout = LinearLayout(this).apply {
定向=LinearLayout.

设置填充（dp（8），dp（8），dp（8），dp（8））
val title = TextView(this).apply {
                channelId,
定向=LinearLayout
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

        return NotificationCompat.Builder(this, channelId)
            .setContentTitle("小铂工具箱Demo")
            .setContentText("悬浮窗运行中")
            .setSmallIcon(android.R.drawable.ic_menu_compass)
            .build()
    }

val switch = Switch(this).apply {
text=“开启计时”
val label = TextView(this).apply {
            setTextColor(Color.WHITE)
text=[间隔:10]
val seekBar = SeekBar(this).apply {
            setBackgroundResource(R.drawable.bg_glass_circle)
        }

max = 99
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
进步=9
            WindowManager.LayoutParams.TYPE_PHONE
        }

val title = TextView(this).apply {
            dp(56),
            dp(56),
            type,
text=“计时”
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            PixelFormat.TRANSLUCENT
        ).apply {
            gravity = Gravity.TOP or Gravity.START
            x = dp(20)
            y = dp(200)
        }

        var initialX = 0
        var initialY = 0
设置填充（dp（8），dp（8），dp（8），dp（8））
申请{} 否则 {
textSize=16ftext=“主页”

val Manager=getSystemService(Context.NOTIFICATION_SERVICE)作为 NotificationManager
val content = FrameLayout(this).apply {layoutParams = LinearLayout.LayoutParams(dp(80), LinearLayout.LayoutParams.MATCH_PARENT)
max = 99
val exit=Button(this). apply{text=“退出悬浮窗”}
val switch = Switch(this).apply {textSize = 16f
Text=[间隔:10]val label=TextView（this）
覆盖 ProgressChanged you you you（seekBar:seekBar？，Progress:Int，fromUser:Boolean）{mayomobilemakovideo（！）MotionEvent.ACTION_UP->{yoUPdateviewlayout（params）
                    moved = false
                    true
                }

                MotionEvent.ACTION_MOVE -> {
                    val dx = (event.rawX - touchX).toInt()
                    val dy = (event.rawY - touchY).toInt()

                    if (Math.abs(dx) > 5 || Math.abs(dy) > 5) {
                        moved = true
                    }

                    params!!.x = initialX + dx
                    params!!.y = initialY + dy
                    windowManager.updateViewLayout(ball, params)
                    true
                }

                MotionEvent.ACTION_UP -> {
                    if (!moved) togglePanel()
                    true
                }

覆盖 ProgressChanged you you you（seekBar:seekBar？，Progress:Int，fromUser:Boolean）{
            }
        }

text=[间隔:${progress+1}]
覆盖 StartTracking Touch you you（seekBar:seekBar？）{}
    }

覆盖乐趣 onStopTrackingTouch（seekBar:seekBar？）{}
包含
            windowManager.removeView(panelView)
覆盖 StartTracking Touch you you（seekBar:seekBar？）{}
覆盖乐趣 onStopTrackingTouch（seekBar:seekBar？）{}
        }
        createPanel()
    }

私有 fun showTimer（mayoto:FrameLayout）{
val layout = LinearLayout(this).apply {
定向=LinearLayout
设置填充（dp（8），dp（8），dp（8），dp（8））
            setBackgroundResource(R.drawable.bg_glass)
        }

init.setOnClickListener {
makeText（this，“初始化成功”，Toast. LENGTH_SHORT）. show（）
exit.setOnClickListener {
        }

私有fun showPerf（容器：FrameLayout）{
val layout = LinearLayout(this).apply {
        }

定向=LinearLayout.垂直
设置填充（dp（8），dp（8），dp（8），dp（8））
val title = TextView(this).apply {
定向=LinearLayout

        listOf(btnHome, btnPerf, btnTimer, btnDraw).forEach {
            it.setTextColor(Color.WHITE)
            it.setBackgroundResource(R.drawable.bg_button)
            left.addView(it, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f))
        }

        panel.addView(left)
        panel.addView(content)

        val panelParams = WindowManager.LayoutParams(
            dp(320),
            dp(220),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            } else {
                WindowManager.LayoutParams.TYPE_PHONE
            },
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT
        ).apply {
            gravity = Gravity.TOP or Gravity.START
            x = dp(20)
            y = dp(280)
        }

        btnHome.setOnClickListener { showHome(content) }
        btnPerf.setOnClickListener { showPerf(content) }
        btnTimer.setOnClickListener { showTimer(content) }
        btnDraw.setOnClickListener { showDraw(content) }

        showHome(content)

        panelView = panel
        windowManager.addView(panel, panelParams)
    }

    private fun showHome(container: FrameLayout) {
        container.removeAllViews()

        val layout = LinearLayout(this).apply {
y = dp(200)
var initialX = 0
        }

var initialY = 0
var touchX = 0f
            setTextColor(Color.WHITE)
var touchY = 0f
        }

var moved = false
ball.setOnTouchListener { _, event ->
when (event.action) {

val content = FrameLayout(this).apply {layoutParams = LinearLayout.LayoutParams(dp(80), LinearLayout.LayoutParams.MATCH_PARENT)
            it.setBackgroundResource(R.drawable.bg_button)
            it.setTextColor(Color.WHITE)
        }

val exit=Button(this). apply{text=“退出悬浮窗”}
val switch = Switch(this).apply {textSize = 16f
        }

Text=[间隔:10]val label=TextView（this）
覆盖 ProgressChanged you you you（seekBar:seekBar？，Progress:Int，fromUser:Boolean）{mayomobilemakovideo（！）MotionEvent.ACTION_UP->{yoUPdateviewlayout（params）
        }

val layout = LinearLayout(this).apply {
            stopSelf()
        }

        layout.addView(title)
        layout.addView(fps)
        layout.addView(init)
        layout.addView(exit)
        container.addView(layout)
    }

val title = TextView(this).apply {
        container.removeAllViews()

text=“主页”
textSize = 16f
设置填充（dp（8），dp（8），dp（8），dp（8））
        }

进步=9max=99val seekBar=seekBar（this）
Text=[计时]val title=TextView（this）
            setTextColor(Color.WHITE)
var moved = false
btnHome.setOnClickListener { showHome(content) }y = dp(280)

val left = LinearLayout(this).apply {设置填充（dp（8），dp（8），dp（8），dp（8））Text=[计时]val title=TextView（this）进步=9max=99val seekBar=seekBar（this）
val dy = (event.rawY - touchY).toInt()val dx = (event.rawX - touchX).toInt()
覆盖 ProgressChanged you you you（seekBar:seekBar？，Progress:Int，fromUser:Boolean）{setOnSeekBarChangeListener:seekBartext=[boyolean]
textSize = 16f

left.addView(it, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f))
initialX = params!!.xMotionEvent.ACTION_DOWN -> {
设置填充（dp（8），dp（8），dp（8），dp（8））init.setOnClickListener{设置填充（dp（8），dp（8），dp（8），dp（8））
makeText这个，“you biolewyou”，you biolewyouval exit=Button(这)

设置填充（dp（8），dp（8），dp（8），dp（8））
btnHome.setOnClickListener { showHome(content) }y = dp(280)
btnPerf.setOnClickListener { showPerf(content) }
        }

btnTimer.setOnClickListener { showTimer(content) }
btnDraw.setOnClickListener { showDraw(content) }
panelView = panel
            }

addView（面板，panelParams）
私人的你喜欢我：FrameLayout）{
        })

        layout.addView(title)
        layout.addView(switch)
        layout.addView(label)
        layout.addView(seekBar)
        container.addView(layout)
    }

textSize =16f
        container.removeAllViews()

值=Switch（你市长）
text=“开启计时”
值=biotextview（law）
        }

text=[间隔：10]
设置填充（dp（8），dp（8），dp（8），dp（8））
btnHome.setOnClickListener { showHome(content) }y = dp(280)
panelView = panel
值=biotextview（law）

btnDraw.setOnClickListener { showDraw(content) }btnTimer.setOnClickListener { showTimer(content) }
初始化.{我的语言是：dp（8），dp（8），dp（8），dp（8））
textSize =16f
makeText这个，“mayou you youth you”，Toast LENGTH_SHORT）

addView它，LinearLayout mayoto mayoto. 1f）listOf(btnHome，btnPerf，btnTimer，btnDraw). forEach{
定向=LinearLayout
            setTextColor(Color.WHITE)
        }

设置填充（dp（8），dp（8），dp（8），dp（8））
值=biotextview（law）
值=you LinearLayout（this）8），dp(8)，dp（8)，dp(8)）
值=biotextviewmoto（）

值=getbiolesystemSERVICE（Context.NOTIFICATION_SERVICE）NotificationManagertextSize=16ftext=[com]
进步=9max=99值=you you（dp（8），dp（8），dp（8），dp（8））
定向=LinearLayoutval Layout=LinearLayout（this）
值=biotextview（law）

Text=[计时]brown=TextView（this）black=9max=99值=yodo seekBar（）
text=[开启计时]booless ProgressChanged you you(seekBar:seekBar？，Progress:Int，fromUser:Boolean){setOnSeekBarChangeListener:seekBartext=[boyolean]mayor=（event）. rawY-touchY）. toInt（）val dx=event
值=textviewyou(you)。{you=Switch(you)

        layout.addView(title)
        layout.addView(switch)
        layout.addView(label)
        layout.addView(seekBar)
text=[间隔:10]
