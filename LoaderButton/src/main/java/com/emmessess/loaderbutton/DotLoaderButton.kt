package com.emmessess.loaderbutton

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

class DotLoaderButton : RelativeLayout {
    private var disabledBackground : Int = -1
    private var enabledBackground : Int = -1
    private var title : String = ""

    lateinit var buttonLabel : TextView
    lateinit var loaderView: AMDotsView

    lateinit var linearLayout: LinearLayout
    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        this.linearLayout = LinearLayout(context)

        this.buttonLabel = TextView(context)
        this.buttonLabel.text = "Button Label"
        this.buttonLabel.textAlignment = TEXT_ALIGNMENT_CENTER

        this.loaderView = AMDotsView(context)
        this.loaderView.animationType = AnimationType.SCALE
//        this.loaderView.layoutParams = LayoutParams(100,30)

        this.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)

        val params : LayoutParams = this.layoutParams as LayoutParams
        params.addRule(CENTER_IN_PARENT)

        linearLayout.layoutParams = params

        val buttonParams : LayoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)
        buttonParams.addRule(CENTER_IN_PARENT)
        buttonLabel.layoutParams =  buttonParams

        var loaderParams = LayoutParams(100,80)
        loaderParams.setMargins(25,0,0,0)
        loaderView.layoutParams =  loaderParams

        linearLayout.addView(buttonLabel)
        linearLayout.addView(loaderView)
        this.addView(linearLayout)
        setupAttributes(attrs)

        addCircles()
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.DotLoaderButton, 0, 0)
        title = typedArray.getString(R.styleable.DotLoaderButton_title) ?: "No Title"
        disabledBackground  = typedArray.getResourceId(R.styleable.DotLoaderButton_disabledBackground,-1)
        enabledBackground  = typedArray.getResourceId(R.styleable.DotLoaderButton_enabledBackground,-1)
        buttonLabel.text = title
//        spacing = typedArray.getInt(R.styleable.AMDots_spacing, 10)
//        animationDuration = typedArray.getInt(R.styleable.AMDots_animationDuration, 400)
//        aheadTime = typedArray.getInt(R.styleable.AMDots_aheadTime, 200)
//        hidesWhenStopped = typedArray.getBoolean(R.styleable.AMDots_hidesWhenStopped, true)
//
//        val type = typedArray.getInt(R.styleable.AMDots_animationType, 0)
//        animationType = AnimationType.values()[type]
//
//        val stringColors: Array<CharSequence>? = typedArray.getTextArray(R.styleable.AMDots_colors)
//        var intColors: List<Int>? = null
//
//        if (stringColors != null && stringColors.isNotEmpty()) {
//            intColors = stringColors.map { Color.parseColor(it.toString()) }
//        }
//
//        colors = intColors ?: defaultsColors
//
//        weightSum = colors.size.toFloat()
//
//        gravity = Gravity.CENTER_VERTICAL

        hideLoading()
    }

    fun showLoading(){
        this.loaderView.visibility = VISIBLE
        this.isEnabled = false
        when(disabledBackground){
            -1 ->  this.background = context.getDrawable(android.R.color.transparent)
            else -> this.background = context.getDrawable(disabledBackground)
        }
    }

    fun hideLoading(){
        this.isEnabled = true
        this.loaderView.visibility = GONE
        when(enabledBackground){
            -1 ->  this.background = context.getDrawable(android.R.color.transparent)
            else -> this.background = context.getDrawable(enabledBackground)
        }
    }

    private fun addCircles() {
//        colors.forEachIndexed { _, color ->
//            val view = DotView(context, color)
//            view.layoutParams =
//                LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
//            val layoutParams = view.layoutParams as LinearLayout.LayoutParams
//            layoutParams.setMargins(spacing, spacing, spacing, spacing)
//            layoutParams.gravity = Gravity.CENTER_VERTICAL
//            addView(view)
//        }
//
//        start()
    }

}