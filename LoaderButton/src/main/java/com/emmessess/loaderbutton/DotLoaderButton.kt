package com.emmessess.loaderbutton

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

class DotLoaderButton : RelativeLayout {
    private var disabledBackground : Int = -1
    private var enabledBackground : Int = -1
    private var title : String = ""

    lateinit var buttonLabel : TextView
    lateinit var loaderView: DotsView

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

        this.loaderView = DotsView(context)
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
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.DotLoaderButton, 0, 0)
        title = typedArray.getString(R.styleable.DotLoaderButton_title) ?: "No Title"
        disabledBackground  = typedArray.getResourceId(R.styleable.DotLoaderButton_disabledBackground,-1)
        enabledBackground  = typedArray.getResourceId(R.styleable.DotLoaderButton_enabledBackground,-1)
        val fontName = typedArray.getString(R.styleable.DotLoaderButton_fontName)
        val textSize = typedArray.getFloat(R.styleable.DotLoaderButton_textSize,12f)
        val textColor = typedArray.getColor(R.styleable.DotLoaderButton_textColor,context.resources.getColor(R.color.white))
        this.buttonLabel.typeface = Typeface.create(fontName, Typeface.NORMAL)
        this.buttonLabel.textSize = textSize
        this.buttonLabel.setTextColor(textColor)
        buttonLabel.text = title
        hideLoading()
    }

    fun showLoading(){
        this.loaderView.visibility = VISIBLE
        this.isEnabled = false
        when(disabledBackground){
            -1 ->  this.background = context.resources.getDrawable(android.R.color.transparent)
            else -> this.background = context.resources.getDrawable(disabledBackground)
        }
    }

    fun hideLoading(){
        this.isEnabled = true
        this.loaderView.visibility = GONE
        when(disabledBackground){
            -1 ->  this.background = context.resources.getDrawable(android.R.color.transparent)
            else -> this.background = context.resources.getDrawable(disabledBackground)
        }
    }

    fun disableButton(){
        this.isEnabled = false
        this.loaderView.visibility = GONE
        when(enabledBackground){
            -1 ->  this.background = context.resources.getDrawable(android.R.color.transparent)
            else -> this.background = context.resources.getDrawable(enabledBackground)
        }
    }
}