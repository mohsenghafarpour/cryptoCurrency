package ir.digipay.cryptocurrency.utils

class QueryParams(val data: Map<String, String> = hashMapOf()) {
    fun toBuilder(): Builder {
        return Builder().setData(this.data)
    }

    class Builder {
        private val data: MutableMap<String, String> =
            hashMapOf(
                "CMC_PRO_API_KEY" to "d20cf8cb-c359-4a5e-8ca5-783a6beb90ca",
                "limit" to "20"
            )

        fun setData(data: Map<String, String>): Builder {
            this.data.clear()
            this.data.putAll(data)
            return this
        }

        fun build(): QueryParams {
            return QueryParams(this.data)
        }

        fun addStart(start: Int): Builder {
            this.data["start"] = start.toString()
            return this
        }

        fun addSort(sort: String): Builder {
            this.data["sort"] = sort
            return this
        }

        fun addSortDir(sortDir: String): Builder {
            this.data["sort_dir"] = sortDir
            return this
        }
    }
}