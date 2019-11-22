package com.fansongsong.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fansongsong.entity.Channel;
import com.fansongsong.mapper.ChannelMapper;
import com.fansongsong.service.ChannelService;

@Service
public class ChannelServiceImpl  implements ChannelService{
	
	@Autowired
	ChannelMapper channelMapper;

	@Override
	public List<Channel> list() {
		// TODO Auto-generated method stub
		return channelMapper.list();
	}
}
