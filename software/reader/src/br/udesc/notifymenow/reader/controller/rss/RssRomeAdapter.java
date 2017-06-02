/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.controller.rss;

import br.udesc.notifymenow.reader.model.entity.Noticia;
import br.udesc.notifymenow.reader.util.Logger;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.fetcher.FeedFetcher;
import com.sun.syndication.fetcher.impl.HashMapFeedInfoCache;
import com.sun.syndication.fetcher.impl.HttpURLFeedFetcher;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.fetcher.FetcherException;
import com.sun.syndication.io.FeedException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class RssRomeAdapter implements RssReader {

    @Override
    public List<Noticia> retrieve(String url) {
        return retrieve(url, true);
    }

    @Override
    public List<Noticia> retrieve(String url, boolean cache) {
        SyndFeed response = requestFeed(url, cache);
        return parseFeed(response, null);
    }

    @Override
    public List<Noticia> retrieve(String url, Date date) {
        SyndFeed response = requestFeed(url, false);
        return parseFeed(response, date);
    }

    private SyndFeed requestFeed(String url, boolean cache) {
        FeedFetcher feedFetcher;
        if (cache) {
            feedFetcher = new HttpURLFeedFetcher(HashMapFeedInfoCache.getInstance());
        } else {
            feedFetcher = new HttpURLFeedFetcher();
        }

        try {
            return feedFetcher.retrieveFeed(new URL(url));
        } catch (IllegalArgumentException | IOException | FeedException | FetcherException ex) {
            Logger.error(ex);
        }

        return null;
    }

    private List<Noticia> parseFeed(SyndFeed response, Date date) {
        List<Noticia> feeds = new ArrayList<>();

        Iterator list = response.getEntries().iterator();

        while (list.hasNext()) {
            SyndEntryImpl requestFeed = (SyndEntryImpl) list.next();

            if (date == null || date.before(requestFeed.getPublishedDate())) {
                Noticia feed = new Noticia();
                feed.setConteudo(requestFeed.getDescription().getValue());
                feed.setTitulo(requestFeed.getTitle());
                feed.setLink(requestFeed.getLink());
//                feed.setData(null);
                Logger.info(requestFeed.getSource().toString());

//                feeds.add(feed);
            } else {
                break;
            }
        }

        return feeds;
    }

}
