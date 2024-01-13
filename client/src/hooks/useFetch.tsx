import Axios from "axios";
import { useEffect, useState } from "react";

type dataType = dataArray | null;
type dataArray = Array<{
  id: string;
  fileName: string;
}>;

export default function useFetch(url: string) {
  const [loading, setLoading] = useState(true);
  const [data, setData] = useState<dataType>(null);
  const [error, setError] = useState(null);
  const [reloadFetch, setReloadFetch] = useState(false);
  useEffect(() => {
    setLoading(true);
    Axios.get(url)
      .then((res) => setData(res.data))
      .catch((err) => setError(err))
      .finally(() => setLoading(false));
  }, [url, reloadFetch]);

  function triggerReload() {
    setReloadFetch((prev) => !prev);
  }

  return {
    data,
    loading,
    error,
    setReloadFetch,
    reloadFetch,
    setLoading,
    triggerReload,
  };
}
