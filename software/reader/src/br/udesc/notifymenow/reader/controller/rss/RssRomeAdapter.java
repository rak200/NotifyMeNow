/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.controller.rss;

import com.sun.syndication.fetcher.FeedFetcher;
import com.sun.syndication.fetcher.impl.FeedFetcherCache;
import com.sun.syndication.fetcher.impl.HashMapFeedInfoCache;
import com.sun.syndication.fetcher.impl.HttpURLFeedFetcher;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.fetcher.FetcherException;
import com.sun.syndication.io.FeedException;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class RssRomeAdapter implements RssReader {

    @Override
    public void retrieve(URL url) {
        retrieve(url, true);
    }

    @Override
    public void retrieve(URL url, boolean cache) {
        SyndFeed feed = getFeed(url);
        System.out.println(feed);
    }

    private SyndFeed getFeed(URL url) {
        FeedFetcherCache feedInfoCache = HashMapFeedInfoCache.getInstance();
        FeedFetcher feedFetcher = new HttpURLFeedFetcher(feedInfoCache);
        try {
            return feedFetcher.retrieveFeed(url);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(RssRomeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RssRomeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FeedException ex) {
            Logger.getLogger(RssRomeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FetcherException ex) {
            Logger.getLogger(RssRomeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
