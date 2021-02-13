/*
     *
     * BH Apps
     * version 0.0.2
     * Methods for Get County Flags
     * bhapps.utilitools.countries.kotlin.flags.GetFlags
     *
*/

package bhapps.utilitools.countries.kotlin.lists

import android.content.Context
import bhapps.utilitools.countries.R
import org.xmlpull.v1.XmlPullParser

object GetCountries {

    fun getFullListOfCountriesAndDataAsHashMap(context: Context, key: String) : HashMap<String, HashMap<Any, Any>> {

        /*

        <country>
        <name value="Andorra" />
        <english_name value="Andorra" />
        <name_code value="ad" />
        <phone_code value="376" />
        </country>

         */

        var result = HashMap<String, HashMap<Any, Any>>()
        val xml = context.resources.getXml(R.xml.countries)

        /*
        while (xml.eventType != XmlPullParser.END_DOCUMENT) {
            if (xml.eventType ==XmlPullParser.START_TAG) {
                if (xml.name.equals("country")) {
                    data_array.add(xml.getAttributeValue(0))
                }
            }

            xml.next()
        }
        */

        xml.nextTag()
        xml.require(XmlPullParser.START_TAG, null, "countries")
        while (xml.nextTag() === XmlPullParser.START_TAG) {
            xml.require(XmlPullParser.START_TAG, null, "country")

            xml.nextTag()
            xml.require(XmlPullParser.START_TAG, null, "name")
            val name = xml.nextText()
            xml.require(XmlPullParser.END_TAG, null, "name")

            xml.nextTag()
            xml.require(XmlPullParser.START_TAG, null, "name_code")
            val name_code = xml.nextText()
            xml.require(XmlPullParser.END_TAG, null, "name_code")

            var child_nodes_result = HashMap<Any, Any>()
            child_nodes_result.put("name", name)
            child_nodes_result.put("name_code", name_code)

            result.put(name_code, child_nodes_result)

            //end
            xml.nextTag()
            xml.require(XmlPullParser.END_TAG, null, "country")
        }
        xml.require(XmlPullParser.END_TAG, null, "countries")

        return result
    }

    
}