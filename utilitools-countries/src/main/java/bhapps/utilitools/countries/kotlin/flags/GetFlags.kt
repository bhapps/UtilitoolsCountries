/*
     *
     * BH Apps
     * version 0.0.2
     * Methods for Get County Flags
     * bhapps.utilitools.countries.kotlin.flags.GetFlags
     *
*/

package bhapps.utilitools.countries.kotlin.flags

import android.content.Context
import android.graphics.drawable.Drawable
import bhapps.utilitools.countries.R

object GetFlags {

    fun getFlagDrawableByCountryKey(context: Context, key: String) : Drawable {
        var flag_drawable = R.drawable.bhapps_utilitools_countries_country_flag_unknown
        if(key!=null){
            try {

                val drawable_name = "bhapps_utilitools_countries_country_flag_" + key
                val getDrawableFromStringValue = context.resources.getIdentifier(drawable_name, "drawable", context.packageName)
                flag_drawable = getDrawableFromStringValue

            }catch (exception: Exception) {
                //skip ...
            }
        }
        return context.getDrawable(flag_drawable)
    }

    fun getFlagDrawableIntByCountryKey(context: Context, key: String) : Int {
        var flag_drawable = R.drawable.bhapps_utilitools_countries_country_flag_unknown
        if(key!=null){
            try {

                val drawable_name = "bhapps_utilitools_countries_country_flag_" + key
                val getDrawableFromStringValue = context.resources.getIdentifier(drawable_name, "drawable", context.packageName)
                flag_drawable = getDrawableFromStringValue

            }catch (exception: Exception) {
                //skip ...
            }
        }
        return flag_drawable
    }
    
}